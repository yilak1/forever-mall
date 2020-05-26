package com.lym.controller.center;

import com.lym.controller.BaseController;
import com.lym.pojo.Users;
import com.lym.pojo.bo.center.CenterUserBO;
import com.lym.pojo.vo.center.UserInfoVO;
import com.lym.service.center.CenterUserService;
import com.lym.utils.CookieUtils;
import com.lym.utils.DateUtil;
import com.lym.utils.IMOOCJSONResult;
import com.lym.utils.JsonUtils;
import com.lym.pojo.Users;
import com.lym.pojo.bo.center.CenterUserBO;
import com.lym.service.center.CenterUserService;
import com.lym.utils.CookieUtils;
import com.lym.utils.IMOOCJSONResult;
import com.lym.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "用户信息接口", tags = {"用户信息相关接口"})
@RestController
@RequestMapping("userInfo")
public class CenterUserController extends BaseController {

    @Autowired
    private CenterUserService centerUserService;



    @ApiOperation(value = "修改用户的信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("/update")
    public IMOOCJSONResult update(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name ="centerUserBO", value = "对userInfo传入的修改", required = true)
            @RequestBody CenterUserBO centerUserBO,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
        if(StringUtils.isBlank(userId)) {
            return IMOOCJSONResult.errorMsg("userId不能是空");
        }

        UserInfoVO userInfoVO = centerUserService.updateUserInfo(userId, centerUserBO);

        userInfoVO = setNullProperty(userInfoVO);
        //设置cookies
        CookieUtils.setCookie(servletRequest, servletResponse,
                "user", JsonUtils.objectToJson(userInfoVO), true);

        // TODO 后续要改，增加令牌token，会整合进redis，分布式会话

        //所有修改之后的内容已经显示在了界面上，我现在比较好奇的是传进来的centerUserBo究竟是什么
        return IMOOCJSONResult.ok();


    }


    private UserInfoVO setNullProperty(UserInfoVO userResult) {
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setBirthday(null);
        return userResult;
    }




    @ApiOperation(value = "更新用户头像", notes = "更新用户头像", httpMethod = "POST")
    @PostMapping("uploadFace")
    public IMOOCJSONResult uploadFace(
            @ApiParam(name = "userId", value = "用户的id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
            MultipartFile file,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {

        //定义头像保存的位置
        String fileSpace = IMAGE_USER_FACE_LOCATION;

        //定义每个文件的目录
        String filePrefix = File.separator + userId;

        //网络请求的路径位置
        String webFilePath = null;
        //开始进行文件按上传
        if(file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                //文件的名字
                String originalFilename = file.getOriginalFilename();

                if(StringUtils.isNotBlank(originalFilename)) {
                    //验证文件的名字
                    String[] split = originalFilename.split("\\.");
                    if(split.length != 2) {
                        return IMOOCJSONResult.errorMsg("文件名称的格式不正确");
                    }
                    String suffix = split[split.length - 1];
                    if(!suffix.equalsIgnoreCase("png") &&
                            !suffix.equalsIgnoreCase("jpg") &&
                            !suffix.equalsIgnoreCase("jpeg")) {
                        return IMOOCJSONResult.errorMsg("图片的格式不符合要求");
                    }
                    //重组文件名
                    String fileName = "face-" + userId +System.currentTimeMillis() + "." + suffix;
                    //最终文件的保存位置
                    String finalFileSpace = fileSpace + filePrefix + File.separator + fileName;

                    //web请求的地址
                    //  /userId/face-userId1234.png
                    webFilePath = filePrefix + "/" + fileName;

                    //上传文件
                    File outFile = new File(finalFileSpace);
                    if(outFile.getParentFile() != null) {
                        //创建了这个文件夹
                        outFile.getParentFile().mkdirs();
                    }
                    //文件输出保存到目录
                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                try {
                    if(fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            return IMOOCJSONResult.errorMsg("文件不能为空");
        }
        //获取图片的服务地址，也就是可以通过web进行访问的地址
        String imageServerUrl = "http://localhost:8088";

        //由于浏览器存在缓存的请框，因此我们需要加上时间戳来保证更新之后的图片可以及时刷新
        String finalUserFaceUrl = imageServerUrl + webFilePath + "?t=" +
                                    DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);

        UserInfoVO  userResult = centerUserService.updateUserFace(userId, finalUserFaceUrl);
        //更新用户的头像到数据库
        userResult = setNullProperty(userResult);
        CookieUtils.setCookie(servletRequest, servletResponse,
                   "user", JsonUtils.objectToJson(userResult), true);


        //TODO 后续进行的更改，增加令牌token，会整合进redis， 分布式会话
        return IMOOCJSONResult.ok();
    }


/*

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息", httpMethod = "POST")
    @PostMapping("update")
    public IMOOCJSONResult update(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @RequestBody @Valid CenterUserBO centerUserBO,
            BindingResult result,
            HttpServletRequest request, HttpServletResponse response) {

        System.out.println(centerUserBO);

        // 判断BindingResult是否保存错误的验证信息，如果有，则直接return
        if (result.hasErrors()) {
            Map<String, String> errorMap = getErrors(result);
            return IMOOCJSONResult.errorMap(errorMap);
        }

        UserInfoVO userResult = centerUserService.updateUserInfo(userId, centerUserBO);

        userResult = setNullProperty(userResult);
        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // TODO 后续要改，增加令牌token，会整合进redis，分布式会话

        return IMOOCJSONResult.ok();
    }

    private Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList) {
            // 发生验证错误所对应的某一个属性
            String errorField = error.getField();
            // 验证错误的信息
            String errorMsg = error.getDefaultMessage();

            map.put(errorField, errorMsg);
        }
        return map;
    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
        return userResult;
    }
*/

}

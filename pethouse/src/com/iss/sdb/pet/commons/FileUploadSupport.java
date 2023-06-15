/**
 * FileUploadSupport.java 2016年9月22日
 * 
 * Copyright 2001-2016  All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.iss.sdb.pet.commons;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iss.sdb.commons.models.FileUpResModel;
import com.iss.sdb.commons.utils.MultipartResolver;
import com.iss.sdb.commons.utils.Office2PDFUtil;

/**
 * 公共文件上传
 * 
 * @author hqsunc
 * @since 2016年9月22日
 *
 */
@Component
public class FileUploadSupport {

    /**
     * 统一上传文件路径前缀
     */
    private static final String RESOURCES = "resources/";

    /**
     * 法律条文文件路径前缀
     */
    private static final String LAW_RESOURCE = "pet/";

    /**
     * 文件路径
     */
    private static final String FILE_PATH = "file/";
    
    /**
     * 上传成功后转成WORD文档路径
     */
    private static final String PDF_PATH = "pdf/";

    /**
     * 法律条文文件上传路径
     */
    private static final String LAW_RESOURCE_FILE = RESOURCES + LAW_RESOURCE + FILE_PATH;
    

    /**
     * 多文件上传分解器
     */
    @Autowired
    private MultipartResolver multipartResolver;

    /**
     * 上传教辅资源文件
     *
     * @author hqsunc
     * @param request
     * @return
     * @throws IOException
     * @since 2016年9月22日
     */
    public List<FileUpResModel> lawResourceFile(HttpServletRequest request) throws IOException {
        List<FileUpResModel> fileList = multipartResolver.upload(request, LAW_RESOURCE_FILE);
        for(FileUpResModel file : fileList){
            file.setConvertFileName(file.getNewFileName());
        }
        return fileList;
    }
}

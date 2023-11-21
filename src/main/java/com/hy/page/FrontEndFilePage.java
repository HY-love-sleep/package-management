package com.hy.page;

import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Description: 前端文件界面
 * Author: yhong
 * Date: 2023/11/21
 */
@Erupt(name = "前端包管理")
@Table(name = "front_file")
@Entity
public class FrontEndFilePage extends BaseModel {

    @EruptField(
            views = @View(
                    title = "文件"
            ),
            edit = @Edit(
                    title = "文件",
                    type = EditType.ATTACHMENT, notNull = true,
                    attachmentType = @AttachmentType
            )
    )
    private String file;

    @EruptField(
            views = @View(
                    title = "文件介绍"
            ),
            edit = @Edit(
                    title = "文件介绍",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String description;

    @EruptField(
            views = @View(
                    title = "所属项目"
            ),
            edit = @Edit(
                    title = "所属项目",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String project;

    @EruptField(
            views = @View(
                    title = "包版本", sortable = true
            ),
            edit = @Edit(
                    title = "包版本",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String jarVersion;

    @EruptField(
            views = @View(
                    title = "日期时间", sortable = true
            ),
            edit = @Edit(
                    title = "日期时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.DATE_TIME)
            )
    )
    private Date dateTime;

    @EruptField(
            views = @View(
                    title = "上传用户"
            ),
            edit = @Edit(
                    title = "上传用户",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "hy", label = "洪岩"),
                            @VL(value = "zxb", label = "张晓波"),
                            @VL(value = "lxy", label = "李星熠"),
                    })
            )
    )
    private String uploadUser;

}
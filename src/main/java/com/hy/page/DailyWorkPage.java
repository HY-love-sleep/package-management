package com.hy.page;

import javax.persistence.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

/**
 * Description: 工作日报管理
 * Author: yhong
 * Date: 2023/11/21
 */

@Erupt(name = "工作日报")
@Table(name = "daily_work")
@Entity
public class DailyWorkPage extends BaseModel {

    @EruptField(
            views = @View(
                    title = "用户"
            ),
            edit = @Edit(
                    title = "用户",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "hy", label = "洪岩"),
                            @VL(value = "zxb", label = "张晓波"),
                            @VL(value = "lxy", label = "李星熠"),
                    })
            )
    )
    private String userName;

    @EruptField(
            views = @View(
                    title = "日报内容"
            ),
            edit = @Edit(
                    title = "日报内容",
                    type = EditType.TEXTAREA, notNull = true
            )
    )
    private @Lob String content;

    @EruptField(
            views = @View(
                    title = "日报日期", sortable = true
            ),
            edit = @Edit(
                    title = "日报日期",
                    type = EditType.DATE, search = @Search, notNull = true,
                    dateType = @DateType(type = DateType.Type.DATE_TIME)
            )
    )
    private Date dateTime;

    @EruptField(
            views = @View(
                    title = "摘要"
            ),
            edit = @Edit(
                    title = "摘要",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String abstractContent;

    @EruptField(
            views = @View(
                    title = "进度"
            ),
            edit = @Edit(
                    title = "进度",
                    type = EditType.SLIDER,
                    sliderType = @SliderType(max = 100)
            )
    )
    private Integer progress;

    @EruptField(
            views = @View(
                    title = "日报附件"
            ),
            edit = @Edit(
                    title = "日报附件",
                    type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType
            )
    )
    private String attachment;

}
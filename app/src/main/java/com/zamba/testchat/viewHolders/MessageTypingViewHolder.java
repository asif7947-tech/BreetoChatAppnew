package com.zamba.testchat.viewHolders;

import android.view.View;

import com.zamba.testchat.models.AttachmentTypes;

/**
 * Created by a_man on 5/11/2017.
 */

public class MessageTypingViewHolder extends BaseMessageViewHolder {
    public MessageTypingViewHolder(View itemView) {
        super(itemView, AttachmentTypes.NONE_TYPING,null);
    }
}

package com.epam.tat.webdriver.factory;

import com.epam.tat.webdriver.bo.NominationBO;

public class NominationFactory {

    public NominationBO getDefaultNomination() {
        return new NominationBO
                .Builder("Helen HR_Manager", "Autotest_title_vk", "Autotest_award_message_vk")
                .chooseAwardReason("REASON1")
                .chooseAwardType("Award1")
                .build();
    }
}

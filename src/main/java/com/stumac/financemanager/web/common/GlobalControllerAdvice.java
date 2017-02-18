package com.stumac.financemanager.web.common;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
class GlobalControllerAdvice
{

    private final BuildProperties buildProperties;

    @ModelAttribute("buildProperties")
    BuildProperties buildProperties()
    {
        return buildProperties;
    }
}

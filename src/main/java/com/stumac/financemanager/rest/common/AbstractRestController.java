package com.stumac.financemanager.rest.common;

import org.springframework.hateoas.Link;

import static org.springframework.hateoas.Link.REL_SELF;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequestUri;

public abstract class AbstractRestController
{

    protected Link getSelfLink()
    {
        return new Link(fromCurrentRequestUri().toUriString(), REL_SELF);
    }
}

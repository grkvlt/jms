/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.jms.test.locator;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.seam.jms.annotations.Routing;
import org.jboss.seam.jms.bridge.Route;
import org.jboss.seam.jms.bridge.RouteLocator;
import org.jboss.seam.jms.bridge.RouteType;
import org.jboss.seam.jms.test.Util;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author johnament
 */
@RunWith(Arquillian.class)
public class LocatorTest {
    @Inject
    RouteLocator routeLocator;
    @Inject
    @Routing(RouteType.EGRESS)
    List<Route> egressRoutes;
    @Inject
    @Routing(RouteType.INGRESS)
    List<Route> ingressRoutes;

    @Deployment
    public static Archive<?> createDeployment() {
        return Util.createDeployment(RouteLocator.class, LocatorInterface.class);
    }

    @Test
    public void testLocatorVerify() {
        Route route = routeLocator.findById(LocatorInterface.class.getCanonicalName() + "." + "obsStringToTopic");
        Assert.assertNotNull(route);
        Assert.assertEquals("Failed size match", egressRoutes.size(), 1, 0);
        Assert.assertEquals("Failed size match", ingressRoutes.size(), 0, 0);
    }
}

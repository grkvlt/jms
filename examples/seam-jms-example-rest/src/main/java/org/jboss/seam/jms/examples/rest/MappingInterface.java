/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.jms.examples.rest;

import javax.enterprise.event.Observes;
import javax.jms.Topic;

import org.jboss.seam.jms.annotations.JmsDestination;
import org.jboss.seam.jms.annotations.Routing;
import org.jboss.seam.jms.bridge.RouteType;

/**
 * @author johnament
 */
public interface MappingInterface {
    @Routing(RouteType.EGRESS)
    public void mapLongsToTopic(@Observes String s, @JmsDestination(jndiName = "jms/LongT2") Topic t);

    @Routing(RouteType.INGRESS)
    public void mapsObjsToTop(@Observes Long l, @JmsDestination(jndiName = "jms/LongT4") Topic t);
}

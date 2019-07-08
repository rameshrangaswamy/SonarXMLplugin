/*
 * SonarQube XML Plugin
 * Copyright (C) 2010-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.plugins.xml;

import org.sonar.api.SonarRuntime;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonarsource.analyzer.commons.BuiltInQualityProfileJsonLoader;

public final class XmlSonarWayProfile implements BuiltInQualityProfilesDefinition {

  private final SonarRuntime sonarRuntime;

  public XmlSonarWayProfile(SonarRuntime sonarRuntime) {
    this.sonarRuntime = sonarRuntime;
  }

  @Override
  public void define(Context context) {
    NewBuiltInQualityProfile sonarWay = context.createBuiltInQualityProfile(Xml.SONAR_WAY_PROFILE_NAME, Xml.KEY);
    BuiltInQualityProfileJsonLoader.load(sonarWay, Xml.REPOSITORY_KEY, Xml.SONAR_WAY_PATH, Xml.XML_RESOURCE_PATH, sonarRuntime);
    sonarWay.done();
  }

}

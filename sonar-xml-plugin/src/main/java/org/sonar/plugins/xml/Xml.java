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

import java.util.ArrayList;
import java.util.List;
import org.sonar.api.config.Configuration;
import org.sonar.api.resources.AbstractLanguage;

/**
 * This class defines the XML language.
 *
 * @author Matthijs Galesloot
 */
public class Xml extends AbstractLanguage {

  /** All the valid xml files suffixes. */
  private static final String[] DEFAULT_SUFFIXES = {".xml"};

  /** The xml language key. */
  public static final String KEY = "xml";

  /** The xml language name */
  private static final String XML_LANGUAGE_NAME = "XML";

  public static final String XML_RESOURCE_PATH = "org/sonar/l10n/xml/rules/xml";
  public static final String REPOSITORY_KEY = "xml";
  public static final String REPOSITORY_NAME = "SonarAnalyzer";

  public static final String SONAR_WAY_PROFILE_NAME = "Sonar way";
  public static final String SONAR_WAY_PATH = "org/sonar/l10n/xml/rules/xml/Sonar_way_profile.json";

  private Configuration configuration;

  /**
   * Default constructor.
   *
   * @param configuration configuration to configure this class
   */
  public Xml(Configuration configuration) {
    super(KEY, XML_LANGUAGE_NAME);
    this.configuration = configuration;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String[] getFileSuffixes() {
    String[] suffixes = filterEmptyStrings(configuration.getStringArray(XmlPlugin.FILE_SUFFIXES_KEY));
    if (suffixes.length == 0) {
      suffixes = Xml.DEFAULT_SUFFIXES;
    }
    return suffixes;
  }

  private static String[] filterEmptyStrings(String[] stringArray) {
    List<String> nonEmptyStrings = new ArrayList<>();
    for (String string : stringArray) {
      if (!string.trim().isEmpty()) {
        nonEmptyStrings.add(string.trim());
      }
    }
    return nonEmptyStrings.toArray(new String[nonEmptyStrings.size()]);
  }
}

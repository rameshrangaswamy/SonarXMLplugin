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
package org.sonar.plugins.xml.checks;

import java.util.Collections;
import org.sonar.check.Rule;
import org.sonarsource.analyzer.commons.xml.XmlFile;
import org.sonarsource.analyzer.commons.xml.XmlTextRange;
import org.sonarsource.analyzer.commons.xml.checks.SonarXmlCheck;

@Rule(key = CharBeforePrologCheck.RULE_KEY)
public class CharBeforePrologCheck extends SonarXmlCheck {

  public static final String RULE_KEY = "S1778";

  @Override
  public void scanFile(XmlFile file) {
    file.getPrologElement().ifPresent(prologElement -> {
      XmlTextRange prologStartLocation = prologElement.getPrologStartLocation();
      if (prologStartLocation.getStartLine() != 1 || prologStartLocation.getStartColumn() != 0) {
        reportIssue(prologStartLocation, "Remove all characters located before \"<?xml\".", Collections.emptyList());
      }
    });
  }

}

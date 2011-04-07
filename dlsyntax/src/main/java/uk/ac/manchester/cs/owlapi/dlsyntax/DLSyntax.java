/*
 * This file is part of the OWL API.
 *
 * The contents of this file are subject to the LGPL License, Version 3.0.
 *
 * Copyright (C) 2011, The University of Manchester
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 *
 * Alternatively, the contents of this file may be used under the terms of the Apache License, Version 2.0
 * in which case, the provisions of the Apache License Version 2.0 are applicable instead of those above.
 *
 * Copyright 2011, The University of Manchester
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.manchester.cs.owlapi.dlsyntax;
/**
 * Author: Matthew Horridge<br>
 * The University Of Manchester<br>
 * Bio-Health Informatics Group<br>
 * Date: 10-Feb-2008<br><br>
 */
public enum DLSyntax {

    SUBCLASS("\u2291"),

    EQUIVALENT_TO("\u2261"),

    NOT("\u00AC"),

    DISJOINT_WITH(SUBCLASS + " " + NOT),

    EXISTS("\u2203"),

    FORALL("\u2200"),

    IN("\u2208"),

    MIN("\u2265"),

    EQUAL("="),

    NOT_EQUAL("\u2260"),

    MAX("\u2264"),

    INVERSE("\u207B"),  // Superscript minus

    AND("\u2293"),

    TOP("\u22A4"),

    BOTTOM("\u22A5"),

    OR("\u2294"),

    COMP("\u2218"),

    WEDGE("\u22C0"),

    IMPLIES("\u2190"),

    COMMA(","),

    SELF("self");




    private String unicodeSymbol;


    DLSyntax(String unicode) {
        this.unicodeSymbol = unicode;
    }


    @Override
	public String toString() {
        return unicodeSymbol;
    }
}

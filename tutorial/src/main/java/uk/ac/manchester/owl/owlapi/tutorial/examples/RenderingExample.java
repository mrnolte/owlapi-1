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
 * Copyright 2011, University of Manchester
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

package uk.ac.manchester.owl.owlapi.tutorial.examples;

import gnu.getopt.Getopt;
import gnu.getopt.LongOpt;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import uk.ac.manchester.owl.owlapi.tutorial.io.OWLTutorialSyntaxOntologyFormat;
import uk.ac.manchester.owl.owlapi.tutorial.io.OWLTutorialSyntaxOntologyStorer;

import java.net.URI;

/**
 * <p>Simple Rendering Example. Reads an ontology and then renders it.</p>
 * <p/>
 * Author: Sean Bechhofer<br>
 * The University Of Manchester<br>
 * Information Management Group<br>
 * Date: 24-April-2007<br>
 * <br>
 */
public class RenderingExample {

    public static void main(String[] args) {
        // A simple example of how to load and save an ontology
        try {

            /* Command line arguments */
            LongOpt[] longopts = new LongOpt[11];
            String inputOntology = null;
            String outputOntology = null;

            longopts[0] = new LongOpt("help", LongOpt.NO_ARGUMENT, null, '?');
            longopts[1] = new LongOpt("input", LongOpt.REQUIRED_ARGUMENT, null,
                    'i');
            longopts[2] = new LongOpt("output", LongOpt.REQUIRED_ARGUMENT,
                    null, 'o');

            Getopt g = new Getopt("", args, "?:i:o", longopts);
            int c;

            while ((c = g.getopt()) != -1) {
                switch (c) {
                    case '?':
                        System.out.println("RenderingExample --input=URL --output=URL");
                        System.exit(0);
                    case 'i':
                        /* input */
                        inputOntology = g.getOptarg();
                        break;
                    case 'o':
                        /* input */
                        outputOntology = g.getOptarg();
                        break;
                }
            }

            /* Get an Ontology Manager */
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            if (inputOntology == null || outputOntology == null) {
                System.out.println("RenderingExample --input=URL --output=URL");

                System.exit(1);
            }

            IRI inputDocumentIRI = IRI.create(inputOntology);
            IRI outputDocumentIRI = IRI.create(outputOntology);

            /* Load an ontology from a document IRI */

            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(inputDocumentIRI);
            /* Report information about the ontology */
            System.out.println("Ontology Loaded...");
            System.out.println("Document IRI: " + inputDocumentIRI);
            System.out.println("Logical IRI : " + ontology.getOntologyID());
            System.out.println("Format      : "
                    + manager.getOntologyFormat(ontology));

            /* Register the ontology storer with the manager */
            manager.addOntologyStorer(new OWLTutorialSyntaxOntologyStorer());

            /* Save using a different format */

            System.out.println("Storing     : " + outputDocumentIRI);
            manager.saveOntology(ontology, new OWLTutorialSyntaxOntologyFormat(), outputDocumentIRI);
            /* Remove the ontology from the manager */
            manager.removeOntology(ontology);
            System.out.println("Done");

        } catch (OWLException e) {
            e.printStackTrace();
        }
    }
}

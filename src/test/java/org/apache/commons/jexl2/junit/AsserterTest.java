/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* $Id: AsserterTest.java 1125721 2011-05-21 14:53:18Z henrib $ */
package org.apache.commons.jexl2.junit;

import junit.framework.AssertionFailedError;

import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.JexlTestCase;
import org.apache.commons.jexl2.Foo;

/**
 *  Simple testcases
 *
 *  @since 1.0
 */
public class AsserterTest extends JexlTestCase {
    public AsserterTest(String testName) {
        super(testName);
    }

    public void testThis() throws Exception {
        Asserter asserter = new Asserter(JEXL);
        asserter.setVariable("this", new Foo());
        
        asserter.assertExpression("this.get('abc')", "Repeat : abc");
        
        try {
            asserter.assertExpression("this.count", "Wrong Value");
            fail("This method should have thrown an assertion exception");
        }
        catch (AssertionFailedError e) {
            // it worked!
        }
    }

    public void testVariable() throws Exception {
        JexlEngine jexl = new JexlEngine();
        jexl.setSilent(true);
        Asserter asserter = new Asserter(jexl);
        asserter.setVariable("foo", new Foo());
        asserter.setVariable("person", "James");

        asserter.assertExpression("person", "James");
        asserter.assertExpression("size(person)", new Integer(5));
        
        asserter.assertExpression("foo.getCount()", new Integer(5));
        asserter.assertExpression("foo.count", new Integer(5));
        
        try {
            asserter.assertExpression("bar.count", new Integer(5));
            fail("This method should have thrown an assertion exception");
        }
        catch (AssertionFailedError e) {
            // it worked!
        }
    }
}

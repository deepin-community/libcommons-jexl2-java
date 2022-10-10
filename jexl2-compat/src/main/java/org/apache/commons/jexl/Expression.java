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

package org.apache.commons.jexl;

/**
 * Jexl-1.x compatible expression.
 * @since 2.0
 * @version $Id$
 */
public interface Expression extends org.apache.commons.jexl2.Expression {
    /**
     * Evaluates the expression with the variables contained in the
     * supplied {@link JexlContext}.
     *
     * @param context A JexlContext containing variables.
     * @return The result of this evaluation
     * @throws Exception on any error
     */
    Object evaluate(JexlContext context) throws Exception;
}

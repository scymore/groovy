/*
 * Copyright 2003-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */











package org.codehaus.groovy.classgen.asm.sc.bugs

import groovy.transform.stc.StaticTypeCheckingTestCase
import org.codehaus.groovy.classgen.asm.sc.StaticCompilationTestSupport

class Groovy7356Bug extends StaticTypeCheckingTestCase implements StaticCompilationTestSupport {
    void testShouldNotFailCompilationBecauseOfForEachAndTry() {
        assertScript '''

            private void foo(String[] arr) {

                for (String s in arr.iterator()) {
                    try {
                        println(s)
                    } catch (e) {
                    }
                }

            }

            foo(['a', 'b'] as String[])
        '''
    }

    void testShouldNotFailCompilationBecauseOfForEachAndTryDirectArray() {
        assertScript '''

            private void foo(String[] arr) {

                for (String s in arr) {
                    try {
                        println(s)
                    } catch (e) {
                    }
                }

            }

            foo(['a', 'b'] as String[])
        '''
    }
}
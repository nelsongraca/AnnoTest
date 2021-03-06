/*
 * @author Ali Akhtar
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.aliakhtar.annoTest.util;

import org.junit.After;
import org.mockito.Mockito;

import javax.annotation.processing.Messager;
import javax.annotation.processing.Processor;

public abstract class AnnoTest<P extends Processor>
{
    protected final Messager messager;
    protected final ProcessorWrapper<P> processor;
    protected final Compiler compiler;

    public AnnoTest(P processor, Class... classPathEntries)
            throws Exception
    {
        messager = Mockito.mock(Messager.class);
        this.processor = new ProcessorWrapper<>(processor, messager);
        compiler = new Compiler(classPathEntries);
    }


    @After
    public void tearDown()
    {
        compiler.cleanUp();
    }
}

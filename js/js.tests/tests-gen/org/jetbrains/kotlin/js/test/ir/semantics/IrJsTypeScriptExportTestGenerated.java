/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.js.test.ir.semantics;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.kotlin.test.TargetBackend;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("js/js.translator/testData/typescript-export")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class IrJsTypeScriptExportTestGenerated extends AbstractIrJsTypeScriptExportTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
    }

    public void testAllFilesPresentInTypescript_export() throws Exception {
        KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
    }

    @TestMetadata("js/js.translator/testData/typescript-export/constructors")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Constructors extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInConstructors() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/constructors"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("constructors.kt")
        public void testConstructors() throws Exception {
            runTest("js/js.translator/testData/typescript-export/constructors/constructors.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/constructors/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/constructors/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/declarations")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Declarations extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInDeclarations() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/declarations"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("declarations.kt")
        public void testDeclarations() throws Exception {
            runTest("js/js.translator/testData/typescript-export/declarations/declarations.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/declarations/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/declarations/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/inheritance")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Inheritance extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInInheritance() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/inheritance"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("inheritance.kt")
        public void testInheritance() throws Exception {
            runTest("js/js.translator/testData/typescript-export/inheritance/inheritance.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/inheritance/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/inheritance/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/namespaces")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Namespaces extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInNamespaces() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/namespaces"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("namespaces.kt")
        public void testNamespaces() throws Exception {
            runTest("js/js.translator/testData/typescript-export/namespaces/namespaces.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/namespaces/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/namespaces/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/primitives")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Primitives extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInPrimitives() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/primitives"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("primitives.kt")
        public void testPrimitives() throws Exception {
            runTest("js/js.translator/testData/typescript-export/primitives/primitives.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/primitives/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/primitives/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/selectiveExport")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class SelectiveExport extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInSelectiveExport() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/selectiveExport"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("selectiveExport.kt")
        public void testSelectiveExport() throws Exception {
            runTest("js/js.translator/testData/typescript-export/selectiveExport/selectiveExport.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/selectiveExport/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/selectiveExport/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }

    @TestMetadata("js/js.translator/testData/typescript-export/visibility")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Visibility extends AbstractIrJsTypeScriptExportTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
        }

        public void testAllFilesPresentInVisibility() throws Exception {
            KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/visibility"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
        }

        @TestMetadata("visibility.kt")
        public void testVisibility() throws Exception {
            runTest("js/js.translator/testData/typescript-export/visibility/visibility.kt");
        }

        @TestMetadata("js/js.translator/testData/typescript-export/visibility/JS_TESTS")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class JS_TESTS extends AbstractIrJsTypeScriptExportTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest0(this::doTest, TargetBackend.JS_IR, testDataFilePath);
            }

            public void testAllFilesPresentInJS_TESTS() throws Exception {
                KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("js/js.translator/testData/typescript-export/visibility/JS_TESTS"), Pattern.compile("^([^_](.+))\\.kt$"), null, TargetBackend.JS_IR, true);
            }
        }
    }
}

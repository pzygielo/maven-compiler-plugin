/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

def logFile = new File( basedir, 'build.log' )
assert logFile.exists()
content = logFile.text

/*
 * The message expected by this test was "[WARNING] unchecked call" (the full message
 * is actually "unchecked call to add(E) as a member of the raw type java.util.List").
 * But we cannot test that message because it is locale-dependent.
 * Check only a few keywords instead.
 */
assert content.contains( '[WARNING]' )
assert content.contains( 'add(E)' )
assert content.contains( 'List' ) // May be `List` or `java.util.List`.
assert content.contains( 'COMPILATION ERROR:' )
assert content.contains( 'CompilationFailureException' ) // In debug level logs.

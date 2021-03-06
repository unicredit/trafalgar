/* Copyright 2016 UniCredit S.p.A.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import akka.actor._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._

object Main extends App {
  implicit val system = ActorSystem("example")
  implicit val mat = ActorMaterializer()

  Source(1 to 100)
    .map(_.toDouble)
    .via(Trafalgar.flow)
    .runWith(Sink.foreach(println))
}

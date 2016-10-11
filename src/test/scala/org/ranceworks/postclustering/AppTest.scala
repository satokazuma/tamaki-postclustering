package org.ranceworks.postclustering

import java.io.File
import java.util

import collection.mutable.Stack
import org.scalatest._
import org.apache.commons.io.FileUtils
import org.junit.Test
import collection.JavaConverters._

class AppTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
     //   println(new File(getClass.getResource("C50").toURI))
    val a: util.Collection[File] =   FileUtils.listFiles(new File(getClass.getResource("C50").toURI), Array("txt"),true)
    //a.asScala.foreach( p => println(p.getName))

    App.toRdd(a.asScala.toList)

    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[Int]
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}

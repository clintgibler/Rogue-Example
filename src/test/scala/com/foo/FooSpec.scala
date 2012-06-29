package com.foo

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.BeforeAndAfter

class FooSpec extends Spec with ShouldMatchers with BeforeAndAfter {

  before {
    FooDB.connectToMongo
  }

  after {
    FooDB.disconnectFromMongo
  }

  describe("Foo") {
    it("Basic foo creation") {
      Foo.createRecord.name("some_foo").save
      Foo where (_.name eqs "some_foo").count should equal (1)
    }
  }
}

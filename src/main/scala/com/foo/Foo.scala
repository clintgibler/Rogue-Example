package com.foo

import com.foursquare.rogue.Rogue._

import com.mongodb.{Mongo, ServerAddress}
import net.liftweb.mongodb.{MongoDB, MongoIdentifier}
import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._
import net.liftweb.record.field._
import net.liftweb.record._
import org.bson.types.ObjectId

object FooDB extends MongoIdentifier {
  override def jndiName = "rogue_mongo"

  private var mongo: Option[Mongo] = None

  def connectToMongo = {
    val MongoPort = 37648
    mongo = Some(new Mongo(new ServerAddress("localhost", MongoPort)))
    MongoDB.defineDb(FooDB, mongo.get, "rogue-test")
  }

  def disconnectFromMongo = {
    mongo.foreach(_.close)
    MongoDB.close
    mongo = None
  }
}

class Foo extends MongoRecord[Foo] with MongoId[Foo] {
  def meta = Foo
  object name extends StringField(this, 150)
}

object Foo extends Foo with MongoMetaRecord[Foo] {
  override def collectionName = "foos"
  override def mongoIdentifier = FooDB
}

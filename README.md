# Spark Jobserver sbt project #

[![Build Status](https://secure.travis-ci.org/spark-jobserver/spark-jobserver.g8.png)](http://travis-ci.org/spark-jobserver/spark-jobserver.g8)


[g8](httphttps://github.com/foundweekends/giter8) template to get a Spark Jobserver application up and running quickly.

## Use this template ##

- [Install giter8 (g8)](https://github.com/foundweekends/giter8) (NOTICE: 0.6.8 or higher required)
- Get the g8 template and run it:

```sh
$ sbt new spark-jobserver/spark-jobserver.g8
$ cd <name-of-app>
$ sbt package
```

- Upload the jar to Spark Jobserver and run the application.

## Modify this template ##

- [Install sbt](http://www.scala-sbt.org/), version 0.13.0 or higher.
- Fork [spark-jobserver/spark-jobserver.g8](https://github.com/spark-jobserver/spark-jobserver.g8) on GitHub to your account.
Let's assume your account is "foo".
- Clone it.

```sh
$ git clone git@github.com:foo/spark-jobserver.g8.git
```

- Now make your desired changes.
- Do a local deploy of your modified template and try it out.

```sh
$ sbt
> g8Test # must result in SUCCESS
> exit
$ cd target/sbt-test/default-*/scripted
$ sbt package
```

- Test the jar using Spark Job Server

- If you like your new template, push it to GitHub.

```sh
$ cd /path/to/spark-jobserver.g8.git
$ git push
```

- You can now access your modified template using g8.

```sh
$ cd
$ sbt new foo/spark-jobserver.g8
```

- If you'd like to share your changes, send a pull request.
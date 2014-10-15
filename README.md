The first 6Wunderkinder code problem is to fetch the latest 100 tweets
related to 6Wunderkinder and print them out.

I plan to use `lein` to generate a project (so, sadly there will be a
folder in this folder) and go from there. I'll also try to keep a log of
what I learn here. I'm reading the tutorial provided by `lein help
tutorial`.

## Usage

First, create an application on twitter and note your consumer key and
secret. Then:

```sh
cd twitter-fetcher
CONSUMER_KEY=abc CONSUMER_SECRET=xyz lein run
```

- - -

## Changelog

* Edited the project.clj file with my info
* Added clj-http as a dependency
* Reading the consumer key and secret from the env with
  `(System/getenv)`
* The base64 stuff is very confusing. A [Stackoverflow link][] is
  helping, but I have no idea what any of it does. Will leave a comment
  for later.
* Added dependecies for the base64 and json
* Figured out that the `:key-fn` is just simply running every key
  through a function and the `keyword` function simply makes keywords
  from strings
* Learned that `str` is how one concat's strings
* Could'nt get `map` to work, so I used `doseq` instead. I don't
  understand why I couldn't use `map`.

[Stackoverflow link]: http://stackoverflow.com/questions/11825444/clojure-base64-encoding

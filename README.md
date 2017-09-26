# textsearch
Built and run using IntelliJ IDEA 2017.2 on Java 9.



Accents won't work. Would have to do something about ignoring accents for search by converting to basis characters.
The logic should be put in ITextLineExtractStrategy. I also put in that interface so that it could be pushed further to
interpret files content in different ways, like ignoring HTML tags for examples. It could also be split into two interfaces,
one that is for normalizing strings and one for deciding how to convert lines into words.

Ideas:
* store one trie for all files and reference the file at word ending
* ranking, store word entry order in the trie and use to rank partial (or also full) search success

from __future__ import absolute_import
import pytest
import WordDictionary

@pytest.mark.gen_test
def test_word_search():
    wd = WordDictionary()
    wd.add("sad")
    print "here"
    assertEquals(len(wd.trie), 3)

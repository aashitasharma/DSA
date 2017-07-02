from __future__ import absolute_import
class WordDictionary(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        trie = []


    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        for i in range(0, len(word)):
            if(i >= len(self.trie)):
                self.trie.append(set())
            if word[i] not in trie[i]:
                self.trie[i].add(word[i])


    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        for i in range(0, len(word)):
            if(word[i]!='.'):
                if(word[i] not in self.trie[i]):
                    return False
        return True



# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)

'''
How many unique identifiers possible? Will you run out of unique URLs?
Should the identifier be increment or not? Which is easier to design? Pros and cons?
Mapping an identifier to an URL and its reversal - Does this problem ring a bell to you?
How do you store the URLs? Does a simple flat file database work?
What is the bottleneck of the system? Is it read-heavy or write-heavy?
Estimate the maximum number of URLs a single machine can store.
Estimate the maximum number of queries per second (QPS) for decoding a shortened URL in a single machine.
How would you scale the service? For example, a viral link which is shared in social media could result in a peak QPS at a moment's notice.
How could you handle redundancy? i,e, if a server is down, how could you ensure the service is still operational?
Keep URLs forever or prune, pros/cons? How we do pruning? (Contributed by @alex_svetkin)
What API would you provide to a third-party developer? (Contributed by @alex_svetkin)
If you can enable caching, what would you cache and what's the expiry time? (Contributed by @Humandroid)
'''


class Codec:

    def __init__(self):
        self.db = {}
        self.nextId = 0
        self.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        self.baseUrl = 'http://tinyurl.com/'

    def convertToBase62(self, id):
        res = []
        base = len(self.alphabet)
        while id >= base:
            r = id % base
            res.append(r)
            id = id / base
        res.append(int(id))
        shortUrl = ""
        for i in range(len(res) - 1, -1, -1):
            shortUrl += self.alphabet[i]
        return self.baseUrl+shortUrl

    def convertToBase10(self, id):
      exp = 0
      res = 0
      base = len(self.alphabet)
      for i in range(len(id) - 1, -1 , -1):
        res += id[i]*pow(base, exp)
        exp+=1
      return res

    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """
        self.db[self.nextId] = longUrl
        self.nextId+=1
        return self.convertToBase62(self.nextId)


    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """
        id = shortUrl.split('/')[-1]
        print(id)
        res = []
        for i in range(0, len(id)):
          res.append(id.index(id[i]))
        return self.db[self.convertToBase10(res)]



# Your Codec object will be instantiated and called as such:
url = 'https://leetcode.com/problems/design-tinyurl'
codec = Codec()
e = codec.encode(url)
print(e)
print(codec.decode(e))

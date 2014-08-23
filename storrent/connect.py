#!/usr/bin/python

import sys, os, hashlib, StringIO
import bencode
import urllib
import re

def main():

  print sys.argv[1];
  path = sys.argv[1];
  if (path.endswith(".torrent")):
      # Open torrent file
    	# And get the info hash
      torrent_file = open(path, "rb")
      metainfo = bencode.bdecode(torrent_file.read())
      info = metainfo['info']
      print urllib.quote_plus(hashlib.sha1(bencode.bencode(info)).digest())
    

      print hashlib.sha1(bencode.bencode(info)).hexdigest()    
  else:
    	#Magnetic link (Whole Link if u enter this in the console u need to use quotes "" around the link else i didnt get the whole link)
      url = urllib.unquote(path)
      id = re.search('(?<=urn:btih:)(.*)(?=&dn)',url).group(0)
      name = re.search('(?<=dn=)(.*)(?=&tr)', url).group(0)
      print name

    

    

if __name__ == "__main__":
    main()
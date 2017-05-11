#/bin/sh
inputfile=$1
configfile=$2
outputfile=$3
echo "configfile:$configfile"
echo "inputfile: $inputfile"
echo "outputfile: $outputfile"

if [ -f "$configfile" ]
then
  echo "$configfile found."

  while IFS='=' read -r key value
  do
    key=$(echo $key | tr '.' '_')
    eval "${key}='${value}'"
  done < "$configfile"

  echo "Title       = " ${title}
  echo "Environment = " ${environment}
else
  echo "$configfile not found."
fi

fspec=$outputfile 
filename="${fspec##*/}"
dirname="${fspec%/*}"
echo $filename
echo $dirname
if [ ! -d "$dirname" ]
then
	
	mkdir -p $dirname
echo "File doesn't exist. Creating now"
    
else [ ! -f "$outputfile" ]
     touch $outputfile
	 echo "File exists"
fi


cp -Rvf $inputfile $outputfile

#sed -i '3d' $outputfile

titlepattern='\[\[title\]\]'
titlereplacement=${title}

envpattern='\[\[environment\]\]'
envReplacepattern=${environment}

sed -i "s/$titlepattern/$titlereplacement/g" $outputfile
sed -i "s/$envpattern/$envReplacepattern/g" $outputfile
echo "Done"
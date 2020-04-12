#include <iostream>
#include <map>

using namespace std;

class YoutubeInterface
{
public:
    virtual string downloadVideo(string videoURL) = 0;
    virtual ~YoutubeInterface() {}
};

class YoutubeReal : public YoutubeInterface
{
public:
    map <string, string> videos = {{"video1URL", "dogVideo.mp4"}, {"video2URL", "catVideo.mp4"}};
    string downloadVideo(string videoURL) override {
        auto iter = videos.find(videoURL);
        if ( iter == videos.end() ) {
            cerr << "Video doesn't exist";
            exit;
        } else {
            cout << "Downloading video from YoutubeReal: " + iter->second << endl;
            return iter->second;
        }
    }
};

class YoutubeProxy : public YoutubeInterface
{
private:
    YoutubeInterface* youtubeReal;
    map <string, string> cachedVideos;
public:
    YoutubeProxy() : youtubeReal (new YoutubeReal())
    {}
    ~YoutubeProxy() {
        delete youtubeReal;
    }
    // Forward calls to the YoutubeReal:
    string downloadVideo(string videoURL) override {
        auto iter = cachedVideos.find(videoURL);
        if ( iter == cachedVideos.end() ) {
            //video not in cache, download from youtube and cache it
            string videoObject = youtubeReal->downloadVideo(videoURL);
            cout << "caching video: " + videoObject << endl;
            pair<string, string> videoPair = make_pair(videoURL, videoObject);
            cachedVideos.insert(videoPair);
            return videoObject;
        } else {
            cout << "Returning cached video from Youtube Proxy: " + iter->second << endl;
            return iter->second; //return cached video
        }
    }
};

void clientDownloadVideos(YoutubeInterface *youtube)
{
    //client interacts with interface, which happens to be a proxy
    //downloading video for the first time, calls youtube real
    youtube->downloadVideo("video1URL");
    cout << endl;

    //downloading same video second time, proxy catches this and returns cached video
    youtube->downloadVideo("video1URL");
    cout << endl;

    //download new video2 for the first time, calls youtube real
    youtube->downloadVideo("video2URL");
}

int main() {
    YoutubeProxy p;
    clientDownloadVideos(&p);
}
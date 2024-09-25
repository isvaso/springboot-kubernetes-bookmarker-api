import {fetchBookmarks} from "@/app/services/api";
import Bookmarks from "@/app/components/Bookmarks";
import {BookmarksResponse} from "@/app/services/models";
import {GetServerSideProps, NextPage} from "next";

interface HomeProps {
    bookmarks: BookmarksResponse;
}

const Home = async ({searchParams}: { searchParams: { page?: string } }) => {
    const page = searchParams.page ? parseInt(searchParams.page, 10) : 1;
    const bookmarks: BookmarksResponse = await fetchBookmarks(page);

    return (
        <div>
            <h1>Welcome to Bookmarker</h1>
            <Bookmarks bookmarks={bookmarks}/>
        </div>
    );
};

export default Home;

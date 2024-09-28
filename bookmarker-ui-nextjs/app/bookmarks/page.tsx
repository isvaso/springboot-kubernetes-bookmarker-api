import {BookmarksResponse} from "../services/models";
import {fetchBookmarks} from "../services/api";
import Bookmarks from "../components/Bookmarks";


interface HomeProps {
    bookmarks: BookmarksResponse;
}

const Home = async ({searchParams}: { searchParams: { page?: string, query?: string } }) => {
    const page = searchParams.page ? parseInt(searchParams.page, 10) : 1;
    const query = searchParams.query ? searchParams.query : "";
    const bookmarks: BookmarksResponse = await fetchBookmarks(page, query);

    return (
        <div>
            <h1>Welcome to Bookmarker</h1>
            <Bookmarks bookmarks={bookmarks}/>
        </div>
    );
};

export default Home;

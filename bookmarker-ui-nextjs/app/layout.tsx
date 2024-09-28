import './styles/globals.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import NavBar from './components/NavBar';
import Head from 'next/head';
import {ReactNode} from 'react';

export const metadata = {
    title: 'Bookmarks',
    description: 'Manage your bookmarks easily.',
};

export default function RootLayout({children}: { children: ReactNode }) {
    return (
        <html lang="en">
        <Head>
            <meta name="viewport" content="width=device-width, initial-scale=1"/>
        </Head>
        <body>
        <NavBar/>
        <main>
            {children}
        </main>
        </body>
        </html>
    );
}

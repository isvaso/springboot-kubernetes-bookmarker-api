"use client";
import React, {FC, useState} from "react";
import {saveBookmark} from "../../services/api";

const AddBookmark: FC = () => {
    const [title, setTitle] = useState("");
    const [url, setUrl] = useState("");
    const [message, setMessage] = useState<string | null>(null);
    const [error, setError] = useState<string | null>(null);

    const handleSubmit = async (e: React.SyntheticEvent) => {
        e.preventDefault();
        setError(null);
        if (!url) {
            alert("Please enter URL");
            return;
        }

        const payload = {title, url};

        try {
            const response = await saveBookmark(payload);
            console.log("SaveBookmark response: ", response);
            setTitle("");
            setUrl("");
            setMessage("Bookmark saved successfully");
        } catch (err) {
            console.error("Error saving bookmark:", err);
            setError("Failed to save bookmark");
        }
    };

    return (
        <div>
            <div className="card">
                <div className="card-header text-center">
                    <h2>Create New Bookmark</h2>
                </div>
                <div className="card-body">
                    <div className="card-text">
                        {message && (
                            <div className="alert alert-primary" role="alert">
                                {message}
                            </div>
                        )}
                        {error && (
                            <div className="alert alert-danger" role="alert">
                                {error}
                            </div>
                        )}
                        <form onSubmit={handleSubmit}>
                            <div className="mb-3">
                                <label htmlFor="url" className="form-label">URL</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="url"
                                    value={url}
                                    onChange={(e) => setUrl(e.target.value)}
                                />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="title" className="form-label">Title</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="title"
                                    value={title}
                                    onChange={(e) => setTitle(e.target.value)}
                                />
                            </div>
                            <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AddBookmark;

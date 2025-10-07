import React, { useState } from "react";

const QuoteForm = () => {
  const [text, setText] = useState("");
  const [author, setAuthor] = useState("");
  const [tags, setTags] = useState("");
  const [message, setMessage] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setMessage(null);
    setError(null);
    setLoading(true);
    try {
      const response = await fetch("/api/quotes", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          text,
          author,
          tags: tags
            .split(",")
            .map((tag) => tag.trim())
            .filter(Boolean),
        }),
      });
      if (!response.ok) {
        const err = await response.json();
        throw new Error(err.message || "Failed to add quote");
      }
      setMessage("Quote added successfully!");
      setText("");
      setAuthor("");
      setTags("");
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <form
      onSubmit={handleSubmit}
      style={{
        maxWidth: 400,
        margin: "0 auto",
        display: "flex",
        flexDirection: "column",
        gap: 12,
      }}
    >
      <label>
        Quote Text:
        <input
          type="text"
          value={text}
          onChange={(e) => setText(e.target.value)}
          required
          placeholder="Enter quote text"
        />
      </label>
      <label>
        Author:
        <input
          type="text"
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
          required
          placeholder="Enter author name"
        />
      </label>
      <label>
        Tags (comma-separated):
        <input
          type="text"
          value={tags}
          onChange={(e) => setTags(e.target.value)}
          placeholder="e.g. inspiration, work"
        />
      </label>
      <button type="submit" disabled={loading}>
        {loading ? "Submitting..." : "Add Quote"}
      </button>
      {message && <div style={{ color: "green" }}>{message}</div>}
      {error && <div style={{ color: "red" }}>{error}</div>}
    </form>
  );
};

export default QuoteForm;

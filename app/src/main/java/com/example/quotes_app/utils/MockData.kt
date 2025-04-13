package com.example.quotes_app.utils

import com.example.quotes_app.model.QuotesListData
import com.example.quotes_app.model.Result

val quotes = listOf(
    Result(
        _id = "bfNpGC2NI",
        author = "Thomas Edison",
        content = "As a cure for worrying, work is better than whisky.",
        tags = listOf("Humorous"),
        authorSlug = "thomas-edison",
        length = 51,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "ghVnmSpeAo",
        author = "Thomas Edison",
        content = "Everything comes to him who hustles while he waits.",
        tags = listOf("Success", "Motivational"),
        authorSlug = "thomas-edison",
        length = 51,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "_92j6kAvwd",
        author = "Thomas Edison",
        content = "I never did a day's work in my life.  It was all fun.",
        tags = listOf("Humorous"),
        authorSlug = "thomas-edison",
        length = 53,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "RTYhCs5Ka",
        author = "Charles Dickens",
        content = "I do not know the American gentleman, god forgive me for putting two such words together.",
        tags = listOf("Humorous"),
        authorSlug = "charles-dickens",
        length = 89,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "RKl9iZrjfP",
        author = "Charles Dickens",
        content = "We need never be ashamed of our tears.",
        tags = listOf("Sadness"),
        authorSlug = "charles-dickens",
        length = 38,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "_EC8bhSDQa",
        author = "Charles Dickens",
        content = "Minds, like bodies, will often fall into a pimpled, ill-conditioned state from mere excess of comfort.",
        tags = listOf("Weakness"),
        authorSlug = "charles-dickens",
        length = 102,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "j7W6pP1XiG",
        author = "Charles Dickens",
        content = "Train up a fig tree in the way it should go, and when you are old sit under the shade of it.",
        tags = listOf("Age", "Wisdom"),
        authorSlug = "charles-dickens",
        length = 92,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "qF9iB6wrCQ",
        author = "Charles Dickens",
        content = "Subdue your appetites, my dears, and you've conquered human nature.",
        tags = emptyList(),
        authorSlug = "charles-dickens",
        length = 67,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "btV2j1uf2t",
        author = "Thomas Edison",
        content = "Faith, as well intentioned as it may be, must be built on facts, not fiction--faith in fiction is a damnable false hope.",
        tags = listOf("Religion"),
        authorSlug = "thomas-edison",
        length = 120,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    ),
    Result(
        _id = "QfeIDluRi_",
        author = "Thomas Edison",
        content = "There is no expedient to which a man will not go to avoid the labor of thinking.",
        tags = listOf("Work"),
        authorSlug = "thomas-edison",
        length = 80,
        dateAdded = "2023-04-14",
        dateModified = "2023-04-14"
    )
).associateBy{it._id}

val quotesListData = QuotesListData(
    count = 10,
    lastItemIndex = 20,
    page = 1,
    results = getQuotesList(),
    totalCount = 2127,
    totalPages = 107,
)

fun getQuotesList() = quotes.values.toList()


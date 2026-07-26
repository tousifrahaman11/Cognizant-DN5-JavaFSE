console.log('Welcome to the Community Portal');

window.addEventListener('load', () => {
    alert('Page fully loaded. Welcome to the Community Portal!');
    initPortal();
});

const eventList = [
    {
        name: 'Summer Music Night',
        date: '2026-07-20',
        category: 'Music',
        location: 'Downtown Park',
        seats: 25,
        price: 12,
        upcoming: true
    },
    {
        name: 'Healthy Living Workshop',
        date: '2026-07-10',
        category: 'Workshop',
        location: 'Community Center',
        seats: 0,
        price: 8,
        upcoming: false
    },
    {
        name: 'Neighborhood Cleanup',
        date: '2026-08-05',
        category: 'Community',
        location: 'River Walk',
        seats: 50,
        price: 0,
        upcoming: true
    },
    {
        name: 'City Concert Series',
        date: '2026-06-28',
        category: 'Music',
        location: 'Main Square',
        seats: 5,
        price: 15,
        upcoming: true
    }
];

let registrationCounts = {};

const getAvailableEvents = events => events.filter(event => event.upcoming && event.seats > 0);

function initPortal() {
    displayEvents(getAvailableEvents(eventList));
    setupFilters();
    setupSearch();
}

function displayEvents(events) {
    const eventCards = document.querySelector('#eventCards');
    eventCards.innerHTML = '';

    if (!events.length) {
        const emptyMessage = document.createElement('p');
        emptyMessage.textContent = 'No upcoming events with available seats were found.';
        eventCards.appendChild(emptyMessage);
        return;
    }

    events.forEach(event => {
        const card = createEventCard(event);
        eventCards.appendChild(card);
    });
}

function createEventCard(event) {
    const card = document.createElement('article');
    card.className = 'eventCard';

    const title = document.createElement('h3');
    title.textContent = event.name;
    card.appendChild(title);

    const details = document.createElement('p');
    details.textContent = `${event.category} at ${event.location} on ${event.date} — ${event.seats} seats left.`;
    card.appendChild(details);

    const info = document.createElement('p');
    info.textContent = `Price: $${event.price}`;
    card.appendChild(info);

    const registerBtn = document.createElement('button');
    registerBtn.textContent = 'Register';
    registerBtn.onclick = () => handleRegister(event);
    card.appendChild(registerBtn);

    return card;
}

function handleRegister(event) {
    try {
        if (!event.upcoming || event.seats <= 0) {
            throw new Error('Event is no longer available.');
        }

        event.seats -= 1;
        registrationCounts[event.category] = (registrationCounts[event.category] || 0) + 1;
        updateRegistrationSummary(event.category);
        displayEvents(getAvailableEvents(eventList));
        console.log(`Registered for ${event.name}. Seats remaining: ${event.seats}`);
    } catch (error) {
        console.error(error.message);
        alert(error.message);
    }
}

function updateRegistrationSummary(category) {
    const count = registrationCounts[category] || 0;
    const summaryText = `${category} registrations: ${count}`;
    let summaryEl = document.querySelector('#registrationSummary');
    if (!summaryEl) {
        summaryEl = document.createElement('p');
        summaryEl.id = 'registrationSummary';
        document.getElementById('registration').appendChild(summaryEl);
    }
    summaryEl.textContent = summaryText;
}

function addEvent(newEvent) {
    eventList.push(newEvent);
    displayEvents(getAvailableEvents(eventList));
}

function filterEventsByCategory(category, callback) {
    const filtered = eventList.filter(event => event.category === category && event.upcoming && event.seats > 0);
    callback(filtered);
}

function setupFilters() {
    const categoryFilter = document.querySelector('#categoryFilter');
    categoryFilter.onchange = () => {
        const values = [...eventList];
        const selectedCategory = categoryFilter.value;
        if (selectedCategory) {
            filterEventsByCategory(selectedCategory, displayEvents);
        } else {
            displayEvents(getAvailableEvents(values));
        }
    };
}

function setupSearch() {
    const searchInput = document.querySelector('#searchInput');
    searchInput.addEventListener('keydown', event => {
        if (event.key === 'Enter') {
            const query = searchInput.value.trim().toLowerCase();
            const results = getAvailableEvents(eventList).filter(item =>
                item.name.toLowerCase().includes(query) || item.location.toLowerCase().includes(query)
            );
            displayEvents(results);
        }
    });
}

async function fetchMockEvents() {
    const spinner = createLoadingSpinner();
    document.body.appendChild(spinner);

    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
        if (!response.ok) {
            throw new Error('Failed to fetch event data');
        }
        const data = await response.json();
        console.log('Fetched mock event response:', data);
    } catch (error) {
        console.error('Fetch error:', error);
    } finally {
        spinner.remove();
    }
}

function createLoadingSpinner() {
    const spinner = document.createElement('div');
    spinner.id = 'loadingSpinner';
    spinner.textContent = 'Loading events...';
    spinner.style.position = 'fixed';
    spinner.style.top = '1rem';
    spinner.style.right = '1rem';
    spinner.style.padding = '0.75rem 1rem';
    spinner.style.backgroundColor = 'rgba(47, 109, 183, 0.95)';
    spinner.style.color = '#fff';
    spinner.style.borderRadius = '6px';
    return spinner;
}

fetchMockEvents();

class EventItem {
    constructor(name, date, category, location, seats, price) {
        this.name = name;
        this.date = date;
        this.category = category;
        this.location = location;
        this.seats = seats;
        this.price = price;
    }
}

EventItem.prototype.checkAvailability = function () {
    return this.seats > 0;
};

const eventKeysValues = Object.entries(eventList[0]);
console.log('Event object entries:', eventKeysValues);

const musicEvents = eventList.filter(item => item.category === 'Music');
console.log('Music events:', musicEvents.map(item => `${item.category} on ${item.date}`));

function registerUser(formEvent) {
    formEvent.preventDefault();
    const form = document.querySelector('#registrationForm');
    const { name, email, eventType } = form.elements;
    if (!name.value || !email.value || !eventType.value) {
        alert('Please complete all required fields.');
        return;
    }
    console.log('Registration:', name.value, email.value, eventType.value);
}

const registrationForm = document.querySelector('#registrationForm');
if (registrationForm) {
    registrationForm.addEventListener('submit', registerUser);
}

function simulateRegisterPost(data) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (data.name && data.email) {
                resolve({ status: 'success', message: 'Registration saved.' });
            } else {
                reject(new Error('Missing registration fields.'));
            }
        }, 1200);
    });
}

const form = document.querySelector('#registrationForm');
if (form) {
    form.addEventListener('submit', async event => {
        event.preventDefault();
        const formData = new FormData(form);
        const payload = {
            name: formData.get('name'),
            email: formData.get('email'),
            eventType: formData.get('eventType')
        };
        try {
            const response = await simulateRegisterPost(payload);
            console.log('Registration POST result:', response);
            document.getElementById('formConfirmation').textContent = response.message;
        } catch (error) {
            console.error('Registration error:', error);
            document.getElementById('formConfirmation').textContent = error.message;
        }
    });
}

function jQueryNote() {
    console.log('With jQuery, you could use $("#registerBtn").click(...) and .fadeIn()/.fadeOut() to simplify DOM tasks.');
}

jQueryNote();

/*
Answers:
- JavaScript is loaded via <script src="main.js"></script>. console.log prints the welcome message, and an
 alert notifies when the page fully loads.
- Constants store event name/date and let is used for seats. Template literals format event details,
 and -- decreases seats after registration.
- Conditional logic hides past or full events; forEach renders the event list; try/catch handles
 registration errors.
- Functions addEvent(), registerUser(), filterEventsByCategory() are defined; closure tracks total 
registrations per category; callbacks are passed to filtering functions.
- EventItem class models each event; EventItem.prototype.checkAvailability checks seats; 
Object.entries lists keys and values.
- Events are managed in an array, with push, filter, and map processing used for event operations.
- DOM manipulation uses querySelector, createElement, and appendChild to render event cards and update the UI 
during registration.
- Event handling uses onclick for register buttons, onchange for category filter, and keydown for quick search.
- Async fetch is shown with fetch(), then/catch, and async/await with a loading spinner.
- Modern syntax includes let/const, default parameters, destructuring, and spread operators.
- Forms use form.elements, event.preventDefault(), input validation, and inline error messages.
- AJAX simulation uses a fake POST and setTimeout to delay the response.
- Debugging is supported with console logging of form submission and fetch payloads.
- jQuery examples are noted, and frameworks like React/Vue simplify component structure and state management.
*/
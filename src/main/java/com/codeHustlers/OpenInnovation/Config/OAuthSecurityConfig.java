//<!DOCTYPE html>-->
//<!--<html lang="en">-->
//<!--<head>-->
//<!--    <meta charset="UTF-8">-->
//<!--    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
//<!--    <title>Challenges</title>-->
//<!--    <style>-->
//<!--        body {-->
//<!--            font-family: Arial, sans-serif;-->
//<!--            padding: 20px;-->
//<!--        }-->
//<!--        input, textarea {-->
//<!--            display: block;-->
//<!--            margin-bottom: 10px;-->
//<!--            padding: 10px;-->
//<!--            width: 100%;-->
//<!--            max-width: 500px;-->
//<!--            border: 1px solid #ddd;-->
//<!--            border-radius: 5px;-->
//<!--        }-->
//<!--        button {-->
//<!--            padding: 10px 20px;-->
//<!--            background-color: #007bff;-->
//<!--            color: white;-->
//<!--            border: none;-->
//<!--            cursor: pointer;-->
//<!--        }-->
//<!--        button:hover {-->
//<!--            background-color: #0056b3;-->
//<!--        }-->
//<!--        .challenge-list {-->
//<!--            margin-top: 20px;-->
//<!--        }-->
//<!--        .challenge-item {-->
//<!--            background-color: #f9f9f9;-->
//<!--            border: 1px solid #ddd;-->
//<!--            padding: 15px;-->
//<!--            border-radius: 5px;-->
//<!--            margin-bottom: 10px;-->
//<!--            position: relative;-->
//<!--        }-->
//<!--        .submission-btn {-->
//<!--            margin-top: 10px;-->
//<!--            background-color: #28a745;-->
//<!--        }-->
//<!--        .submission-btn:hover {-->
//<!--            background-color: #218838;-->
//<!--        }-->
//<!--    </style>-->
//<!--</head>-->
//<!--<body>-->
//
//<!--<h1>Create a New Challenge</h1>-->
//
//<!--<form id="challengeForm">-->
//<!--    <input type="text" id="companyId" placeholder="Company ID" required>-->
//<!--    <textarea id="challengeDescription" placeholder="Challenge Description" required></textarea>-->
//<!--    <button type="submit">Create Challenge</button>-->
//<!--</form>-->
//
//<!--<h2>Fetch Challenges by Company ID</h2>-->
//<!--<input type="text" id="fetchCompanyId" placeholder="Enter Company ID to Fetch Challenges">-->
//<!--<button onclick="fetchChallenges()">Get Challenges</button>-->
//
//<!--<div class="challenge-list" id="challengeList"></div>-->
//
//<!--<script>-->
//<!--    // Create a new challenge-->
//<!--    document.getElementById('challengeForm').addEventListener('submit', async function(event) {-->
//<!--        event.preventDefault();-->
//
//<!--        const companyId = document.getElementById('companyId').value;-->
//<!--        const challenge = {-->
//<!--            description: document.getElementById('challengeDescription').value,-->
//<!--            companyId: companyId-->
//<!--        };-->
//
//<!--        try {-->
//<!--            const response = await fetch(`/Challenges/${companyId}/createChallenge`, {-->
//<!--                method: 'POST',-->
//<!--                headers: {-->
//<!--                    'Content-Type': 'application/json',-->
//<!--                },-->
//<!--                body: JSON.stringify(challenge),-->
//<!--            });-->
//
//<!--            if (response.ok) {-->
//<!--                alert('Challenge created successfully');-->
//<!--            } else {-->
//<!--                alert('Failed to create challenge');-->
//<!--            }-->
//<!--        } catch (error) {-->
//<!--            console.error('Error:', error);-->
//<!--            alert('Error creating challenge');-->
//<!--        }-->
//<!--    });-->
//
//<!--    // Fetch all challenges for a company-->
//<!--    async function fetchChallenges() {-->
//<!--        const companyId = document.getElementById('fetchCompanyId').value;-->
//<!--        const challengeListDiv = document.getElementById('challengeList');-->
//<!--        challengeListDiv.innerHTML = ''; // Clear previous results-->
//
//<!--        try {-->
//<!--            const response = await fetch(`/Challenges/getChallenges/${companyId}`);-->
//<!--            if (response.ok) {-->
//<!--                const challenges = await response.json();-->
//<!--                challenges.forEach(challenge => {-->
//<!--                    const challengeDiv = document.createElement('div');-->
//<!--                    challengeDiv.className = 'challenge-item';-->
//<!--                    challengeDiv.innerHTML =`-->
//<!--                        <p><strong>Challenge ID:</strong> ${challenge.id}</p>-->
//<!--                        <p><strong>Description:</strong> ${challenge.description}</p>-->
//<!--                        <button class="submission-btn" onclick="viewSubmissions(${challenge.id})">View All Submissions</button>`-->
//<!--                    ;-->
//<!--                    challengeListDiv.appendChild(challengeDiv);-->
//<!--                });-->
//<!--            } else {-->
//<!--                challengeListDiv.innerHTML = '<p>No challenges found for this company.</p>';-->
//<!--            }-->
//<!--        } catch (error) {-->
//<!--            console.error('Error fetching challenges:', error);-->
//<!--            challengeListDiv.innerHTML = '<p>Error fetching challenges.</p>';-->
//<!--        }-->
//<!--    }-->
//
//<!--    // Redirect to the new page for viewing submissions-->
//<!--    function viewSubmissions(challengeId) {-->
//<!--        console.log("clicked");-->
//<!--&lt;!&ndash;        window.location.href = `submissions.html?challengeId=${challenge.Id}`;&ndash;&gt;-->
//<!--    }-->
//<!--</script>-->
//
//<!--</body>-->
//<!--</html>
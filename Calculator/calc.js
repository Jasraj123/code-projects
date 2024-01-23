let expression = '';

function handleButtonClick(event) {
  const buttonValue = event.target.textContent;
  
  if (buttonValue === '=') {
    calculate();
  } else {
    if (buttonValue === 'C') {
      clearResult();
    } else {
      appendCharacter(buttonValue);
    }
  }
}

function appendCharacter(character) {
  expression += character;
  document.getElementById('result').value = expression;
}

function clearResult() {
  expression = '';
  document.getElementById('result').value = '';
}

function calculate() {
  try {
    const result = eval(expression));
    document.getElementById('result').value = result;
    expression = '';
  } catch (error) {
    document.getElementById('result').value = 'Error';
  }
}

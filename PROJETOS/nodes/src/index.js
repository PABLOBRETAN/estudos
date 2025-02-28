const express = require('express')
const app = express()
const PORT = 3000

app.get('/', (req, res) => {
    console.log("ENTROU AQUI")
    res.send("APP gat")
})

app.post('/', (req, res) => {
   res.send("APP post")
})

app.delete('/', (req, res) => {
    res.send("APP delete")
})

app.listen(PORT, () => {
    console.log('App online na porta ${PORT}')
})
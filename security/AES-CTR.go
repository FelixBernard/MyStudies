package main

import (
	"errors"
	"math/rand"
	"time"
)

const (
	blockLength      = 32 // in Bits
	counterBitLength = 5
	maxLength        = (1 << counterBitLength) * blockLength
)

// Bitstring als Slice von ints {0,1}
type Bits []int

// --- Hilfsfunktion: generiert zufällige Bits ---
func genBits(n int) Bits {
	rand.Seed(time.Now().UnixNano())
	b := make(Bits, n)
	for i := range b {
		b[i] = rand.Intn(2)
	}
	return b
}

// --- f(k, b) muss implementiert werden ---
func f(k Bits, b Bits) Bits {
	// TODO: hier echte Kryptofunktion einbauen
	out := make(Bits, blockLength)
	copy(out, b[:blockLength]) // Dummy: kopiert nur die ersten Bits
	return out
}

// --- compX(nonce, counter) = concat(nonce.bits + counter.bits) ---
func compX(nonce Bits, counter int) Bits {
	counterBits := make(Bits, counterBitLength)

	// counter → Binärbits
	for i := counterBitLength - 1; i >= 0; i-- {
		counterBits[i] = counter & 1
		counter >>= 1
	}

	return append(nonce, counterBits...)
}

// --- XOR zweier Bitfolgen gleicher Länge ---
func xorBits(a, b Bits) Bits {
	out := make(Bits, len(a))
	for i := range a {
		out[i] = a[i] ^ b[i]
	}
	return out
}

// --- enc(m, k, iv) ---
func enc(m Bits, k Bits, nonce Bits) (Bits, error) {
	if len(nonce) != blockLength-counterBitLength {
		return nil, errors.New("nonce has wrong length")
	}

	sol := make(Bits, len(m))
	i := 0

	// --- volle Blöcke verarbeiten ---
	for len(m)-(i*blockLength) > blockLength {
		cb_j := f(k, compX(nonce, i))

		mb := m[i*blockLength : i*blockLength+blockLength]

		x := xorBits(cb_j, mb)
		copy(sol[i*blockLength:i*blockLength+blockLength], x)

		i++
	}

	// --- Restblock ---
	rest := len(m) - i*blockLength
	if rest == 0 {
		return sol, nil
	}

	mb := make(Bits, rest)
	copy(mb, m[i*blockLength:])

	// Padding mit 0-Bits
	for len(mb) < blockLength {
		mb = append(mb, 0)
	}

	cb_j := f(k, compX(nonce, i))

	x := xorBits(cb_j, mb)
	copy(sol[i*blockLength:i*blockLength+rest], x[:rest])

	return sol, nil
}

func main() {
	// Beispielaufruf
	m := genBits(100)                         // Nachricht
	k := genBits(blockLength)                 // Key
	nonce := genBits(blockLength - counterBitLength)

	c, err := enc(m, k, nonce)
	if err != nil {
		panic(err)
	}

	println("Encryption done, length:", c)
	for _, v := range c {
		if v == len(c) - 1 {
			println(c[v])
		} else {
			print(c[v])
		}
		
	}
}

    
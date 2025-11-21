import random

block_size = 32
counter_size = 5
nonce_size = block_size - counter_size


def gen_nonce() -> list:
    sol = []
    for i in range(0, nonce_size):
        sol.append(random.randint(0,1))
    return sol

def pipline(nonce, key, counter):
    vector = built_vector(nonce, counter)
    prf_vector = f(vector, key)
    return prf_vector

def enc(m, nonce, key):
    c = []
    j = 0
    if (len(m)/block_size > 2 ** counter_size):
        print("M is to long")
        return c
    while (len(m[j*block_size:]) >= block_size):
        pip_out = pipline(nonce, key, j)
        pip_out = xor(pip_out, m[j*block_size:j*block_size+block_size])
        c = c + pip_out
        j += 1
        print(pip_out)
    if (len(m[j*block_size:]) == 0):
        return c
    else:
        while len(m[j*block_size:]) < block_size:
            m.append(0)
        pip_out = pipline(nonce, key, j)
        pip_out = xor(pip_out, m[j*block_size:j*block_size+block_size+1])
        c = c + pip_out
        return c

def built_vector(nonce:list, counter:int):
    counter = format(counter, "05b")
    counter_bits = [int(b) for b in counter]
    sol = nonce + counter_bits
    return sol

def f(vector, key) -> list:
    return vector

def xor(bits1:list, bits2:list) -> list:
    sol = []
    if (len(bits1) != len(bits2)):
        raise TypeError
    
    for i in range(0, len(bits1)):
        sol.append(bits1[i] ^ bits2[i])

    return sol

def string_to_bit_list(string):
    sol = ''.join(format(ord(c), '08b') for c in string)
    sol = [int(b) for b in sol]
    return sol

def bit_to_string(bits):
    chars = []
    for i in range(0, len(bits), 8):
        byte_bits = bits[i:i+8]
        byte_str = ''.join(str(b) for b in byte_bits)
        byte_val = int(byte_str, 2)
        chars.append(chr(byte_val))
        print(chr(byte_val))
    return ''.join(chars)

def main():
    ### setup
    nonce = gen_nonce()
    print(nonce)

    ### massage
    massage = str(input("Your massage that should be encrypted: \n"))
    massage_bits = string_to_bit_list(massage)
    print(massage_bits)

    ### key
    key = str(input("Your key for the encryption: \n"))
    key = string_to_bit_list(key)
    print(key)

    c = enc(massage_bits, [1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1], key)

    print(c)
    print(bit_to_string(c))
    

if __name__ == '__main__':
    print(f"Block size:{block_size}, counter size:{counter_size}, Nonce size {nonce_size}")
    main()
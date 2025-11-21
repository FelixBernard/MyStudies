import random

block_size = 32
counter_size = 5
nonce_size = block_size - counter_size
nonce = 0



def gen_nonce():
    pass

def main():
    massage = str(input("Your massage that should be encrypted: \n"))
    massage_bits_string = ''.join(format(ord(c), '08b') for c in massage)
    massage_bits = [int(b) for b in massage_bits_string]
    print(massage_bits)
    

if __name__ == '__main__':
    print(f"Blocksize {block_size} countersize {counter_size} Nonce size {nonce_size}")
    main()
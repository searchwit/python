def convert_file(path_in, path_out):
    print("hi")
    with open(path_out, 'w') as out_file:
        with open(path_in, 'r') as in_file:
            for line in in_file:
                line = line.strip('\n')
                line = line[1:-1]
                out_file.write(line + '\n')



# Press the green button in the gutter to run the script.
if __name__ == '__main__':

    path = "c:/test/test1.txt"
    convert_file(path, path + "_out.txt")

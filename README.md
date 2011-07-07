# Jab (a Java bytecode library)

## Installation

### From GitHub

    $ git clone git://github.com/kylc/jab

## Usage

### Parse a class file

    File file = new File("bin/com/kylc/bytecode/internal/ClassFile.class");
    InputStream input = new FileInputStream(file);

    ClassFile classFile = ClassFile.parse(input);
    ClassNode classNode = new ClassNode(classFile);

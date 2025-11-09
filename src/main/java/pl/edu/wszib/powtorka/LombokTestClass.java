package pl.edu.wszib.powtorka;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class LombokTestClass {
    private final int x = 2;
    private int y;
    @Getter(value = AccessLevel.PROTECTED)
    @Setter
    private int z;
}

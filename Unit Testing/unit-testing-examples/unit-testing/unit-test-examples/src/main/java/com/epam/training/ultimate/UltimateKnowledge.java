package com.epam.training.ultimate;

/**
 * <p>Source of the answer to life the universe and everything.</p>
 *
 * @author Robert_Krakomperger
 */
public class UltimateKnowledge {
    private static final Integer THE_ULTIMATE_ANSWER = Integer.valueOf(42);

    /**
     * Returns the ultimate answer.
     *
     * @return answer to life the universe and everything
     */
    public Integer ultimateAnswer() {
        return THE_ULTIMATE_ANSWER;
    }

    /**
     * Checks if parameter is more than the ultimate answer.
     *
     * @param input any integer value
     * @return true if input is more than the ultimate answer
     */
    public boolean isMore(final Integer input) {
        boolean isTheUltimateAnswer = isTheUltimateAnswer(input);
        if (!isTheUltimateAnswer) {
            throw new IllegalStateException("Nothing can be more than the ultimate answer!");
        }
        return isTheUltimateAnswer;
    }

    /**
     * Determines whether the parameter is equal to the ultimate answer.
     *
     * @param input any integer value
     * @return true, if input is equal to the ultimate answer, otherwise false
     */
    public boolean isTheUltimateAnswer(final Integer input) {
        return THE_ULTIMATE_ANSWER.equals(input);
    }
}

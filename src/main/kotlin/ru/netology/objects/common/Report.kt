package ru.netology.objects.common

data class Report(
    val ownerId: Int,
    val commentId: Int,
    val reason: ReasonReport = ReasonReport.SPAM
) {

}

enum class ReasonReport() {
    SPAM, CHILDREN_PORNO, EXTREMISM, VIOLENCE, DRUGS_PROPAGANDA, PORNO, INSULT, APPEAL_TO_SUICIDE
}

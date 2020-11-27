package io.quarkus.qute.deployment;

import java.util.List;
import java.util.Objects;

import io.quarkus.builder.item.SimpleBuildItem;
import io.quarkus.qute.Expression;

/**
 * Represents the result of analysis of all templates.
 */
public final class TemplatesAnalysisBuildItem extends SimpleBuildItem {

    private final List<TemplateAnalysis> analysis;

    public TemplatesAnalysisBuildItem(List<TemplateAnalysis> analysis) {
        this.analysis = analysis;
    }

    public List<TemplateAnalysis> getAnalysis() {
        return analysis;
    }

    static class TemplateAnalysis {

        // Path or other user-defined id; may be null
        public final String id;
        public final String generatedId;
        public final List<Expression> expressions;
        public final String path;

        public TemplateAnalysis(String id, String generatedId, List<Expression> expressions, String path) {
            this.id = id;
            this.generatedId = generatedId;
            this.expressions = expressions;
            this.path = path;
        }

        Expression findExpression(Integer id) {
            for (Expression expression : expressions) {
                if (expression.getGeneratedId() == id) {
                    return expression;
                }
            }
            return null;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((generatedId == null) ? 0 : generatedId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            TemplateAnalysis other = (TemplateAnalysis) obj;
            return Objects.equals(generatedId, other.generatedId);
        }

    }

}
